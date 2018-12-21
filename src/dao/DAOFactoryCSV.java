/**
 * 
 */
package dao;

/**
 * @author levy54u
 *
 */
public class DAOFactoryCSV extends DAOFactory{
	private static final DAOFactoryCSV instance = new DAOFactoryCSV();

	public static DAOFactory getInstance() {
		
		return instance;
	}
	
	public static JeuDAO getJEUDAO(){
		return JeuDAOCSV.getInstance();
	}

}
