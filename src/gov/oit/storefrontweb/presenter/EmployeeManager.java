package gov.oit.storefrontweb.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import gov.oit.storefrontweb.model.Employee;
//import model.Equipment;
import gov.oit.storefrontweb.shared.EMF;
import gov.oit.storefrontweb.shared.ObjectValidator;
import gov.oit.storefrontweb.shared.StringChecker;

public class EmployeeManager{
	
		private List<String> errors;
		
		//Delete user
		//
		
		public EmployeeManager() {	
			errors = new ArrayList();
		}
		
		public List<String> getErrors() {
		   return errors;
		}
			
		//TODO determine whether add should also update
		public boolean addEmployee(			
				String agency, 
				int eid, 
				String email, 
				String employeeName,
				String phone1,
				String phone2,
				String positionNum,
				String unit,
				boolean active) {
				
			    boolean newRec = false;
			    errors.clear();
			    
			    StringChecker stringChecker = new StringChecker();
			    			    
			    //TODO: Add more data error checks here
			    if (!stringChecker.isValidEmail(email)) {
			       errors.add("Not a valid email");
			    }
	            
			
			EntityManager em = EMF.get().createEntityManager();
			ObjectValidator validator = new ObjectValidator();
			
				
		// BEGIN TRANSACTION RECORD FOR ROLLBACK IF NEEDED 
			EntityTransaction txn = em.getTransaction();
			
			txn.begin();
		
			try {
		    //Either get the existing Employee record or create a new one
			Employee employee = em.find(Employee.class, eid);	
			
			if (employee == null) { 
				employee = new Employee(eid); 
			    newRec = true;	
			}
			
			
			//Set fields
			employee.setActive(active);
			employee.setEmail(email);
			employee.setEmployeeName(employeeName);
			employee.setPhone1(phone1);
			employee.setPhone2(phone2);
			employee.setPositionNum(positionNum);
			employee.setUnit(unit);
			
			if (newRec) {
			  em.persist(employee);
			}
			
			else {
			  em.merge(employee);
			}
			
			// COMMIT ENTRIES
			txn.commit();
		
		    } finally {
			  if (txn.isActive()) { txn.rollback(); }
		    }
			
		    em.close();
			
			return true;
		}
	
	
		
		
		
	public List<Employee> retrieveEmployeeList(){
			
			EntityManager em = EMF.get().createEntityManager();
			TypedQuery<Employee> myQuery;
			List<Employee> results = null;
	
			errors.clear();
			
			try
			{
				myQuery = em.createQuery("SELECT e FROM Employee e", Employee.class);
				results = myQuery.getResultList();    
				results = em.merge(results);
				em.clear();
			}
			
			catch(Exception e)
			{
				
				
			}
			
			finally
			{
				em.close();
			}
			
			return results;	
			
		}
	
	
	//Inactivate employee
	public void deleteEmployee(String eid) {
				
		    String qry = "SELECT e FROM Employee e where e.eid = :eid";
		    
		    //Return singleton EntityManager (Google)
			EntityManager em = EMF.get().createEntityManager();

			Employee result = null;
		    int numResults = 0;
			
		    errors.clear();
		    
		    TypedQuery<Employee> myQuery;				
		    
			if (!StringChecker.isValidEID(eid))
			{
				errors.add(String.format("EID %s is invalid", eid));
			}
			
			//Good EID (as far as we know) so proceed
			else {

				myQuery = em.createQuery(qry, Employee.class);			
				myQuery.setParameter("eid", eid);
				
		     //  --- Make sure there is only one record with this EID ---

				numResults = myQuery.getMaxResults();
			
				//No results, bad EID
				if (numResults == 0) {
					errors.add(String.format("No record with eid %s was found", eid));
				}
			
				//More than one record with this EID.  The datastore needs to be
				// adjusted.
				else if (numResults > 1) {
					errors.add(String.format("More than one record for eid %s", eid));
				}

				//One record, as expected
				else {
					try {
						result = myQuery.getSingleResult();
						// BEGIN TRANSACTION
						em.getTransaction().begin();
								
						//Necessary for agency?
						Employee managed = em.merge(result);
						managed.setActive(false);

						// COMMIT ENTRIES
						em.getTransaction().commit();
					}
				
					catch (Exception e){
						//TODO log exception
						throw e;
					}
				
					finally {
						if (em.getTransaction().isActive()) {
							em.getTransaction().rollback();
						}
					}
				}
			}		
		}
		
	public boolean deleteEquipment(){
			
			return true;
			
		}
		
	/*public List<Equipment> retrieveEmployeeEquipment(Employee emp)
		{
			EntityManager em = EMF.get().createEntityManager();
			TypedQuery<Equipment> myQuery;
			List<Equipment> results = null;
	
			
			try
			{
			
				myQuery = em.createQuery("SELECT eq FROM Equipment eq where eq.employee = :empObject", Equipment.class);
				myQuery.setParameter("empObject", emp);
				results = myQuery.getResultList();    
				em.clear();
			}
			
			catch(Exception e)
			{
				
				
			}
			finally
			{
				em.close();
			}
			
			return results;
			
		}*/
		
		@SuppressWarnings("finally")
	public boolean eraseAllRecords(){
			//THIS WILL DELETE THE EMPLOYEES AND ALSO REMOVE THE CHILD RECORDS
			
			EntityManager em = EMF.get().createEntityManager();
			boolean success = false;
			TypedQuery<Employee> myQuery;
			List<Employee> results;
			//List<Equipment> equipList;
			
			try
			{
				// OPEN A TRANSACTION FOR ROLLBACK
				em.getTransaction().begin();
				
				// OBTAIN ALL EMPLOYEE RECORDS
				myQuery = em.createQuery("SELECT e FROM Employee e", Employee.class);
				results = myQuery.getResultList();    
			
				//LOOP THOUGH EACH EMPLOYEE
				for(Employee e: results){
					//OBTAIN CHILD RECORDS
				/*	equipList = em.merge(e).getAllEquipment();				
					
					//LOOP THOUGH EQUIPMENT
					for(Equipment eq : equipList)
					{
					
							
							//REMOVE EQUIPMENT
							e.getAllEquipment().remove(eq);
					}*/
					
					//REMOVE EMPLOYEE
					em.remove(em.merge(e));
				}
				
				//COMMMIT THE CHANGES
				em.getTransaction().commit();
				
				//RELEASE THE EntityManager
				//em.clear();
				
				//STORE RESULT OF PROCESS
				success = true;
			}
			
			catch (Exception ex) {
				success = false;
			}
			
			finally
			{
				em.close();
				return success;	
			}
			
		}
}
