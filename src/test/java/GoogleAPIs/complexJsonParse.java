package GoogleAPIs;

import io.restassured.path.json.JsonPath;

public class complexJsonParse {

    public String coursePrice(){
        return "{\n" +
                "\t\"dashboard\": {\n" +
                "\t\t\"purchaseAmount\": 910,\n" +
                "\t\t\"website\": \"rahulshettyacademy.com\"\n" +
                "\t},\n" +
                "\t\"courses\": [\n" +
                "\t{\n" +
                "\t\t\"title\": \"Selenium Python\",\n" +
                "\t\t\"price\": 50,\n" +
                "\t\t\"copies\": 6\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"title\": \"Cypress\",\n" +
                "\t\t\"price\": 40,\n" +
                "\t\t\"copies\": 4\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"title\": \"RPA\",\n" +
                "\t\t\"price\": 45,\n" +
                "\t\t\"copies\": 10\n" +
                "\t}\n" +
                "\t]\n" +
                "}\n";
    }

    public static void main(String[] args) {

        complexJsonParse cp = new complexJsonParse();
        JsonPath js = new JsonPath(cp.coursePrice());

        //Print No of courses returned by API,
        // .size() can be applied only on Array
        int count = js.getInt("courses.size()");
        System.out.println("Course Count :"+count);

        //Print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Total Amount :"+totalAmount);


        //Print title of first-course
        String firstCourse = js.get("courses[0].title");
        System.out.println("Title of first course :"+firstCourse);

        //Print all course titles and their respective prices
        for(int i=0;i<count;i++){
            String course = js.get("courses["+i+"].title");
            System.out.println("Course "+i+" : "+course);

            int price = js.get("courses["+i+"].price");
            System.out.println("Pirce "+i+" : "+price);
        }

        //Print no of copies sold by RPA course
        for(int i=0;i<count;i++){
            String title = js.get("courses["+i+"].title");
            if(title.equals("RPA")){
                int copies = js.getInt("courses["+i+"].copies");
                System.out.println("No of copies "+copies);
                break;
            }
        }

        //Verify if sum of all course prices matches with purchase amount
        int preValue =0;
        for(int i=0;i<count;i++){
            String title = js.get("courses["+i+"].title");
            int price = js.get("courses["+i+"].price");
            int copies = js.get("courses["+i+"].copies");
            int prod = price*copies;
            System.out.println("--- Title: "+title+" price: "+price+" copies: "+copies+" prod: "+prod+" preValue: "+preValue);
            preValue += prod;
            System.out.println("preValue: "+preValue);
        }
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        if(preValue == purchaseAmount)
            System.out.println("Yaay same purchaseAmount: "+purchaseAmount);
        else
            System.out.println("Not same purchaseAmount: "+purchaseAmount);
    }
}
