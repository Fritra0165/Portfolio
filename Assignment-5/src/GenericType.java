
public class GenericType extends Type{
	//Declare String/Type varialble typeName
	private String genericName;
	private Type parameterType;
	
	// GenericType constructor method
	public GenericType(String genericName, Type parameterType) {
		this.genericName = genericName;
		this.parameterType = parameterType;
	}//END of GenericType constructor
	
	@Override
	public int computeHash() {
		return genericName.hashCode() * 31 + parameterType.computeHash();	
	}//END of computeHash method

	@Override
	public boolean isCompatibleWith(Type other) {
		return other instanceof GenericType &&
				this.genericName.equals(((GenericType) other).genericName) &&
				this.parameterType.isCompatibleWith(((GenericType) other).parameterType);
	}//END of isCompatibleWith method
	
	public Type inferType(Type other) throws TypeMismatchException{
		if (isCompatibleWith(other)) {
			return this;
		}
		throw new TypeMismatchException("Incompatible types for inference in GenericType");
	}//END of inferType method
	
	
}//END of GenericType class
