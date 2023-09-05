package daos;

import javabeans.shoeus;

public interface DaoShoeus {
	
	public shoeus getShoeus();
	public shoeus getShousBybrand(String brand);
	public shoeus getShoeusByColor(String color);
	public shoeus getShouesByCategory(String category);
	
}
