package gov.oit.storefrontweb.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
				String eid, 
				String email, 
				String employeeName,
				String phone1,
				String phone2,
				String positionNum,
				String unit) {
				
			
			    errors.clear();
			    
			    StringChecker stringChecker = new StringChecker();
			    			    
			    //TODO: Add more data error checks here
			    if (!stringChecker.isValidEID(eid)) {
			    	errors.add("Not a valid EID");
			    }
			    
			    if (!stringChecker.isValidEmail(email)) {
			       errors.add("Not a valid email");
			    }
	            
			
			EntityManager em = EMF.get().createEntityManager();
			Employee emp = new Employee();
			ObjectValidator validator = new ObjectValidator();
			
			//TODO: Set properties here
			
		    if (validator.checkForDuplicate(emp)) 
		    {
		    	return false;
		    }
		    else
		    {
		    	try
				{
				
			    // BEGIN TRANSACTION RECORD FOR ROLLBACK IF NEEDED 
			    em.getTransaction().begin();
			    
			    // WRITE EMPLOYEE TO DATASTORE
			    em.persist(emp);
			    
			    // COMMIT ENTRIES
			    em.getTransaction().commit();
			    
				}
					
				catch (Exception e)
				{
					return false;
				}
		
				finally
				{
					em.close();
				}
		 }
		 
	
			
			return true;
		}
	
	public boolean addEquipment(String eqType, String eqName, String email){
			
			EntityManager em = EMF.get().createEntityManager();
			boolean success = false;
			Employee managed = null;
			Employee result = new Employee();
			
			TypedQuery<Employee> myQuery;
	
			//TODO: Update queries for storefront employees
			myQuery = em.createQuery("SELECT e FROM Employee e where e.email = :email", Employee.class);
			myQuery.setParameter("email", email);
			
			try 
			{
				
				result = myQuery.getSingleResult();
				managed = em.merge(result);
				success = true;
			}
			catch (NoResultException e)
			{
				success = false;
			}
			
			
			if (success)
			{
				
				try
				{
				
					// BEGIN TRANSACTION
					em.getTransaction().begin();
					
					
					//TODO Add any embedded objects
					//eq.setEquipmentName(eqName);
					//eq.setEquipmentType(eqType);
					////eq.setOwner(managed);
					
					// ADD EQUIPMENT
					
					//managed.addEquipment(eq);
					
					
					//managed.addEquipment(eq);
				
					
				    // WRITE RECORD TO DATASTORE
				    em.getTransaction().commit();
			
				    success = true;
		    
				}
			    /*catch (Exception e){
			    	success = false;
			    }
	*/
				finally{}
				
				
			}
	
			return success;
			
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
