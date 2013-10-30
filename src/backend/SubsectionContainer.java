package backend;

import java.util.ArrayList;

public abstract class SubsectionContainer
{
  //variables that a subsectionCOntainer can hold
  //note that any subsectionContainer can only hold one of each at a time
	private String title;
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
	
  
	/*
  public SubsectionContainer(String title)
  {
    this.title=title;
  }
  
  public void setTitle(String title)
  {
	  this.title=title;
  }
  
  public String getTitle()
  {
	  return this.title;
  }*/
  
}
