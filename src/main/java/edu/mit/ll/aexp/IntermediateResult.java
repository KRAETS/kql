package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import edu.mit.ll.aexpression.Dimension;
import edu.mit.ll.aexpression.DimensionSet;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.RegistryOperators;
import edu.mit.ll.aexpression.Table;
import edu.mit.ll.aexpression.Tables;
import edu.mit.ll.aexpression.Tag;

public class IntermediateResult {
	private Atom intermediate_atom;
	private Atom2 intermediate_atom2;
	private DimensionSet intermediate_dimset;
	private List<DimensionSet> intermediate_dimsets;
	private List<Field> intermediate_fields;
	private Set<Dimension> intermediate_set_of_dims;
	private List<Table> intermediate_tables;
	private Tables alltables;
	public ProvenanceDataStructure provenance = new ProvenanceDataStructure();

	public Tables getAlltables() {
		return alltables;
	}
	public void setAlltables(Tables alltables) {
		this.alltables = alltables;
	}
	private List<Tag> intermediate_tags;

	public List<Field> getFields(List<Field> allFields){
		if(intermediate_atom!=null){
			if(intermediate_atom.getAtomType().equals(Atom.Type.DIMSET))
				return RegistryOperators.matchFieldsDimensionsFields(allFields, intermediate_atom.getDimSet());
		
		}
		else if(intermediate_atom2!=null){
			return RegistryOperators.matchFieldsDimensionsFields(allFields, intermediate_atom2.getDimSet());
		}
		else if(intermediate_fields!=null)
			return intermediate_fields;
		else
			return null;
		return null;
	}
	public Atom getIntermediate_atom() {
		return intermediate_atom;
	}
	public Atom2 getIntermediate_atom2() {
		return intermediate_atom2;
	}
	public DimensionSet getIntermediate_dimset() {
		return intermediate_dimset;
	}
	public List<DimensionSet> getIntermediate_dimsets() {
		return intermediate_dimsets;
	}
	public List<Field> getIntermediate_fields() {
		return intermediate_fields;
	}
	public Set<Dimension> getIntermediate_set_of_dims() {
		if(intermediate_set_of_dims!= null)
			return intermediate_set_of_dims;
		else if(intermediate_atom!=null)
		{
			if(intermediate_atom.getAtomType().equals(Atom.Type.DIMSET)){
				return intermediate_atom.getDimSet();
			}
			else if(intermediate_atom.getAtomType().equals(Atom.Type.TAGSET)){
				Set<Dimension> returnset = new HashSet<>();
				for(Table t: alltables.getTables()){
					for(Field f:t.getFields()){
						for(Tag tag :f.getTags()){
							for(Tag thistag : this.getIntermediate_atom().getTagSet())
								if(thistag.equals(tag)){
									returnset.add(f.getDimension());
								}
						}
					}
				}
				return returnset;
			}
		}
		else if(intermediate_atom2!= null){
			return intermediate_atom2.getDimSet();
		}
		else
			return intermediate_set_of_dims;
		return intermediate_set_of_dims;
	}
	public List<Table> getIntermediate_tables() {
		if(intermediate_tables!= null)
			return intermediate_tables;
		else if(intermediate_atom!=null)
		{
			List<Table> result = RegistryOperators.matchTablesDimensionSetTables(alltables.getTables(), DimensionSet.generateDimensionSet(intermediate_atom.getDimSet()));
			return result;
		}
		else if(intermediate_atom2!= null){
			List<Table> result = RegistryOperators.matchTablesDimensionSetTables(alltables.getTables(), DimensionSet.generateDimensionSet(intermediate_atom2.getDimSet()));
			return result;
		}
		else
			//Returns null
			return intermediate_tables;
	}
	public List<Tag> getIntermediate_tags() {
		if(intermediate_atom!=null&&intermediate_atom.getAtomType().equals(Atom.Type.TAGSET)){
			intermediate_tags = new LinkedList<>();
			for(Tag t: intermediate_atom.getTagSet()){
				intermediate_tags.add(t);
			}
		}
		return intermediate_tags;
	}
	public void setIntermediate(Atom intermediate_atom) {
		this.intermediate_atom = intermediate_atom;
	}
	public void setIntermediate(Atom2 intermediate_atom2) {
		this.intermediate_atom2 = intermediate_atom2;
	}
	@SuppressWarnings({ "unchecked" })
	public void setIntermediate(List<?> intermediate_list) {
		try{
			this.intermediate_fields = (List<Field>) intermediate_list;
			for(Field f:intermediate_fields)
//			System.out.println(f);
			return;
		}
		catch(Exception e){
			this.intermediate_fields = null;
//			System.out.println("Not field list");
		}
		try{
			this.intermediate_tables = (List<Table>) intermediate_list;
			for(Table f:intermediate_tables)
//				System.out.print(f);

			return;
		}
		catch(Exception e){
			this.intermediate_tables = null;
//			System.out.println("Not table list");
		}
		try{
			this.intermediate_dimsets = (List<DimensionSet>) intermediate_list;
			for(DimensionSet f:intermediate_dimsets)
//				System.out.print(f);
			return;
		}
		catch(Exception e){
			this.intermediate_dimsets = null;
//			System.out.println("Not dimensionset list");
		}
		try{
			this.intermediate_tags = (List<Tag>) intermediate_list;
			for(Tag f:intermediate_tags)
//				System.out.print(f);
			return;
		}
		catch(Exception e){
			this.intermediate_tags = null;
//			System.out.println("Not tag list");
		}
		
	}
	public void setIntermediate_dimset(DimensionSet intermediate_dimset) {
		this.intermediate_dimset = intermediate_dimset;
	}
	public void setIntermediate_set_of_dims(Set<Dimension> intermediate_set_of_dims) {
		this.intermediate_set_of_dims = intermediate_set_of_dims;
	}
	@Override
	public String toString() {
		return "IntermediateResult [intermediate_atom=" + intermediate_atom
				+ ", intermediate_atom2=" + intermediate_atom2
				+ ", intermediate_dimset=" + intermediate_dimset
				+ ", intermediate_dimsets=" + intermediate_dimsets
				+ ", intermediate_fields=" + intermediate_fields
				+ ", intermediate_set_of_dims=" + intermediate_set_of_dims
				+ ", intermediate_tables=" + intermediate_tables
				+ ", alltables=" + alltables + ", intermediate_tags="
				+ intermediate_tags + "]";
	}
	
}
