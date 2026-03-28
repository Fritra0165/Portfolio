
public class ArrayType extends Type{
	// Declare Type variable elementType
	private Type elementType;
	
	//ArrayType constructor method
	public ArrayType(Type elementType) {
		this.elementType = elementType;
	}//END of ArrayType constructor
	
	@Override
	public int computeHash() {
		return 31 * elementType.computeHash();	
	}//END of computeHash method

	@Override
	public boolean isCompatibleWith(Type other) {
		return other instanceof ArrayType && this.elementType.isCompatibleWith(((ArrayType)other).elementType);
		
	}//END of isCompatibleWith method
	
	public Type inferType(Type other) throws TypeMismatchException{
		if (isCompatibleWith(other)) {
			return this;
		}
		throw new TypeMismatchException("Incompatible types for inference in ArrayType");
	}//END of inferType method
}//END of ArrayType class
