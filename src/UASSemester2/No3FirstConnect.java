package UASSemester2;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class No3FirstConnect {
    No3Model[] data = new No3Model[];
    public void Sort(){
        int i, j, counter_i;
        String small;
        int n = this.data.length;
        for(i=0;i<n-1;i++){
            counter_i = i;

            for (j=i+1;j<n;j++){
                if (this.data[j].compareTo(this.data[counter_i])<0){
                    small = this.data[j];

                    String temp = this.data[j];
                    this.data[j] = this.data[i];
                    this.data[i] = temp;
                }
            }
        }
    }
    public void PrintSort(){
        for (int i=0;i<this.data.length;i++){
            System.out.println(this.data[i]+" ");
        }
    }


    public static void main(String[] args) throws IOException {
        No3ConnectURI koneksisaya = new No3ConnectURI();
        URL myAddress = koneksisaya.buildURL
                ("https://dummyjson.com/products/search?q=Laptop");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
        System.out.println(response);
        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<No3Model> responModel = new ArrayList<>();
        for (int i=0;i<responseJSON.length();i++) {
            No3Model resModel = new No3Model();
            JSONObject myJSONObject =
                    responseJSON.getJSONObject(i);
            resModel.setId(myJSONObject.getString("id"));
            resModel.setTitle(myJSONObject.getString("title"));
            resModel.setDescription(myJSONObject.getString("description"));
            resModel.setPrice(myJSONObject.getString("price"));
            resModel.setDiscount(myJSONObject.getString("discountPercentage"));
            resModel.setRating(myJSONObject.getString("rating"));
            resModel.setStock(myJSONObject.getString("stock"));
            resModel.setBrand(myJSONObject.getString("brand"));
            resModel.setCategory(myJSONObject.getString("category"));
            responModel.add(resModel);
        }
        System.out.println("Response Are: ");
        for (int ind=0;ind< responModel.size();ind++){
            System.out.println("ID : " + responModel.get(ind).getId());
            System.out.println("TITLE : " + responModel.get(ind).getTitle());
            System.out.println("DESCRIPTION : " + responModel.get(ind).getDescription());
            System.out.println("PRICE : " + responModel.get(ind).getPrice());
            System.out.println("DISCOUNT : " + responModel.get(ind).getDiscount());
            System.out.println("RATING : " + responModel.get(ind).getRating());
            System.out.println("STOCK : " + responModel.get(ind).getStock());
            System.out.println("BRAND : " + responModel.get(ind).getBrand());
            System.out.println("CATEGORY : " + responModel.get(ind).getCategory());
        }

        No3FirstConnect SS = new No3FirstConnect();
        SS.Sort();
        SS.PrintSort();
    }
}
