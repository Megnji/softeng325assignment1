package services;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services")
public class UniApplication extends Application {
	   private Set<Object> singletons = new HashSet<Object>();
	   private Set<Class<?>> classes = new HashSet<Class<?>>();
	   public UniApplication()
	   {
		  classes.add(Auditor.class);
	      singletons.add(new LectureResourceImp());
	   }

	   @Override
	   public Set<Object> getSingletons()
	   {
	      return singletons;
	   }
	   
	   @Override
	   public Set<Class<?>> getClasses()
	   {
	      return classes;
	   }
}
