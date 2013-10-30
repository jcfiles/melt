package backend;

import java.util.ArrayList;

/*
 * @author Erotokritou Zoe, Stefan Lesnjakovic
 */
public abstract class SubsectionContainer
{
  //variables that a subsectionCOntainer can hold
  //note that any subsectionContainer can only hold one of each at a time

	private Object parent;
	
	public SubsectionContainer()
	{
		super();
	}
	
	public SubsectionContainer(Object parent)
	{
		this.parent = parent;
	}
	
	public Object getParent(){
		return parent;
	} 
}
