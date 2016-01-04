package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.mit.ll.aexpression.*;

public class Atom2 {
	public static enum Type{
		DIMSET,NONE,RESULT,SETOFDIMS
	}
	private Type atomType = Type.NONE;
	private Set<Dimension> dimSet = new HashSet<>();
	private List<Period> periodsApplied = new LinkedList<>();
	public ProvenanceDataStructure provenance = new ProvenanceDataStructure();
	
	public Type getAtomType() {
		return atomType;
	}
	public Set<Dimension> getDimSet() {
		return dimSet;
	}
	public List<Period> getPeriodsApplied(){
		return periodsApplied;
	}
	public void setPeriodsApplied(List<Period> l){
		this.periodsApplied = l;
	}
	public void addPeriod(Period p){
		if(this.periodsApplied.contains(p)){
			return;
		}
		else{
			this.periodsApplied.add(p);
		}
	}
	
	public void setAtomType(Type atomType) {
		this.atomType = atomType;
	}
	public void setDimensions(Set<DimensionSet> inputDimSetSet){
		dimSet = new HashSet<Dimension>();
		for(DimensionSet ds:inputDimSetSet){
			for(Dimension d:ds.getDimensions()){
				dimSet.add(d);
			}
		}
	}	
	public void setDimSet(Set<Dimension> dimSet) {
		this.dimSet = dimSet;
	}
	/**
	 * Returns fields according to the dimensions that it has or if there 
	 * is a list of periods the fields matching the periods
	 * @param allFields
	 * @return
	 */
	public List<Field> resolveToFields(List<Field> allFields){
		if(periodsApplied.size()!=0){
			return RegistryOperators.matchFieldsPeriodsFields(RegistryOperators.matchFieldsDimensionsFields(allFields, this.getDimSet()), periodsApplied);
		}
		else
			return RegistryOperators.matchFieldsDimensionsFields(allFields, this.getDimSet());
	}
	@Override
	public String toString(){
		return "[type:"+this.getAtomType()+" ,dimSet:"+this.getDimSet()+" periodsApplied:"+this.getPeriodsApplied()+"]";
	}
}
