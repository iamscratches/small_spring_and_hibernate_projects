package training.oracle.tms.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.oracle.tms.entities.OffenceEO;
import training.oracle.tms.entities.OwnerDetailsEO;
import training.oracle.tms.entities.RoleMasterEO;
import training.oracle.tms.entities.VehicleDetailsEO;

public class HibernateUtil {
	private static final SessionFactory sessionFactoryRef;
		
	static {
//		Configuration cfg = new Configuration().addClass(OffenceEO.class);
//		cfg.addClass(RoleMasterEO.class);
//		cfg.addClass(VehicleDetailsEO.class);
//		cfg.addClass(OwnerDetailsEO.class);
		Configuration cfg = new Configuration().configure(); // configure method will always load hibernate.cfg.xml [ No need to add entity object EO class ] 
		sessionFactoryRef = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactoryRef;
	}

}
