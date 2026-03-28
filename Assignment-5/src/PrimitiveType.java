
public class PrimitiveType extends Type{
	//Declare String varialble typeName
	private Type typeName;
	
	//Constructor to initialize the type name
	public PrimitiveType(Type typeName) {
		this.typeName = typeName;
	}//END of PrimitiveType constructor
	
	@Override
	public int computeHash() {
		return typeName.hashCode();	
	}//END of computeHash method

	@Override
	public boolean isCompatibleWith(Type other) {
		return other instanceof PrimitiveType && this.typeName.equals(((PrimitiveType)other).typeName);		
	}//END of isCompatibleWith method
	
	public Type inferType(Type other) throws TypeMismatchException{
		if (isCompatibleWith(other)) {
			return this;
		}
		throw new TypeMismatchException("Incompatible types for inference in PrimitiveType");
	}//END of inferType method
}//END of PrimitiveType class 
