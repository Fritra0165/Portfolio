
public abstract class Type implements Inferable, Hashable{
	// Check compatibility between two types
	public abstract boolean isCompatibleWith(Type other);
	
	// Basic hashCode derived from type name; override in subclasses
	public int computeHash() {
		return this.getClass().getSimpleName().hashCode();
	}
}//END of Type class
