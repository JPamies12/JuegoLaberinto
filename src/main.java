
public class main {
	
	public static void main(String[] args) {
		
		int [] vectorabuscar={2, 4, 10, 30, 4, 5};
		int max;
		
		max= buscar_maxim(vectorabuscar);
		System.out.println(max);
				
	}
	
	
	
	
	
	static int buscar_maxim (int[] vector){
		int maxim=vector[0];
		
		for(int i=0; i<vector.length; i++){
			
			if(vector[i] > maxim){
				
				maxim= vector[i];
			}
		}
		
		return maxim;
	}
}
