<<<<<<< HEAD:clientapplication/src/main/java/com/example/clientapplication/domain/Productcategory.java
package com.example.clientapplication.domain;
=======
package com.example.easybuy_buyer_service.model;
>>>>>>> 520e53cedd0ad6135f041d456a0db7d2cd3ebe9c:easybuy-buyer-service/src/main/java/com/example/easybuy_buyer_service/model/Productcategory.java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
<<<<<<< HEAD:clientapplication/src/main/java/com/example/clientapplication/domain/Productcategory.java
public class ProductCategory {
=======
public class Productcategory {
>>>>>>> 520e53cedd0ad6135f041d456a0db7d2cd3ebe9c:easybuy-buyer-service/src/main/java/com/example/easybuy_buyer_service/model/Productcategory.java

	@Id
	@GeneratedValue
	long id;
	
	String name;
}
