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
		
		public boolean addEmployee(			
				String agency, 
				String eid, 
				String email, 
				String employeeName,
				String phone1,
				String phone2,
				String positionNum,
				String unit) {
				
			    errors = new ArrayList<String>();

			    StringChecker stringChecker = new StringChecker();
			    			    
			    //TODO: Add more data error checks here
			    if (!stringChecker.isValidEID(eid)) {
			    	errors.add("Not a valid EID");
			    }
			    
			    if (!stringChecker.isValidEmail(email)) {
			       errors.add("Not a valid email");
			    }
	            
			    if (errors.size() == 0)
			    {
			    	
			    }
			    
			    else
			    {
			    	
			    	
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
		
	public boolean deleteEmploye(String email){
			
			EntityManager em = EMF.get().createEntityManager();
			boolean success = false;
		
			TypedQuery<Employee> myQuery;
			Employee result = null;
			
			myQuery = em.createQuery("SELECT e FROM Employee e where e.email = :email", Employee.class);
			myQuery.setParameter("email", email);
			
			try 
			{
				result = myQuery.getSingleResult();
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
					// ADD EQUIPMENT
					
					Employee managed = em.merge(result);
					
					em.remove(managed);
			
				    // WRITE RECORD TO DATASTORE
				    //Employee managed = em.merge(emp);
				    			    
				    
				    // COMMIT ENTRIES
				    em.getTransaction().commit();
			
				    success = true;
		    
				}
			    catch (Exception e){
			    	success = false;
			    }
	
			}
	
			return success;
			
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
