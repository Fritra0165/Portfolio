import java.util.HashMap;
import java.util.Map;

public class TypeInferenceEngine {	
	// Delcare inferredTypes variable as a Map
	private Map<String, Type> inferredTypes;
	
	// Constructor to initialize inferredTypes as a new HashMap 
	public TypeInferenceEngine() 
	{
		inferredTypes = new HashMap<>();
	} // END of TypeInferenceEngine constructor
	
	//Method to register a name-type pair
	public void registerInferredType(String name, Type type) {
		inferredTypes.put(name, type);
	}//END of registerInferredType method
	
	// Method to return the type
	public Type inferType(String name) throws TypeMismatchException{
		if (inferredTypes.containsKey(name)) {
			// Return the type object if the name exists
			return inferredTypes.get(name);
		}
		else {
			// if the name doesn't exist, throw error message
			throw new TypeMismatchException("Type not found for inference ");
		}
	}//END of inferType method
	
	//Method to clear the inferredType map
	public void clearInferredTypes(){
		//remove all name-type pairs from the inferredType map
		inferredTypes.clear();
	}//END of clearInferredTypes method
	
	//Method to return the map of inferred types
	public Map<String , Type> getInfferedTypes(){
		//return the map
		return inferredTypes;
	}//END of getInfferedTypes
}// END of TypeInferenceEngine class
