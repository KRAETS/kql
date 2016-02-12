package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.Set;
import edu.mit.ll.aexpression.*;

public class Atom {
	public static enum Type{
		DIMSET,DIMSETSET,NONE,TAGSET,RESULT
	}
	private Type atomType = Type.NONE;
	private Set<Dimension> dimSet;
	private Set<DimensionSet> dimSetSet;
	private Result result;
	private Set<Tag> tagSet;
	public ProvenanceDataStructure provenance = new ProvenanceDataStructure();
	public Atom(){
		//Initialize something
		dimSet = new HashSet<>();
		tagSet = new HashSet<>();
		setResult(new Result());
		dimSetSet = new HashSet<>();
	}

	
	public Type getAtomType() {
		return atomType;
	}
	public Set<Dimension> getDimSet() {
		return dimSet;
	}
	public Set<DimensionSet> getDimSetSet() {
		return dimSetSet;
	}

	public Set<Tag> getTagSet() {
		return tagSet;
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
	public void setDimSetSet(Set<DimensionSet> dimSetSet) {
		this.dimSetSet = dimSetSet;
	}

	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}


	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}
	
	@Override
	public String toString(){
		String res= "[type:"+this.getAtomType();
		if(this.getDimSet()!=null){
			if(this.getDimSet().size()!=0){
				res+=" dimSet:"+this.getDimSet();
			}
		}
		if(this.getDimSetSet()!=null){
			if(this.getDimSet().size()!=0){
				res+=" dimSetSet:"+this.getDimSetSet();
			}
		}
		if(this.getResult()!=null){
			if(!result.isEmpty()){
				res+=" result:"+this.getResult();
			}
		}
		if(this.getTagSet()!=null){
			if(this.getTagSet().size()!=0){
				res+=" tagSet:"+this.getTagSet();
			}
		}
		res+="]";
		return res;
	}
}
