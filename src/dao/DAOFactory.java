/**
 * 
 */
package dao;

/**
 * @author levy54u
 *
 */
public abstract class DAOFactory {

	private static final int CSV = 0;

	public DAOFactory getInstance(int type){
		
		switch(type){
		case CSV:
			return DAOFactoryCSV.getInstance();
		}
		return null;
	}

}
