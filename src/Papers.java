public class Papers {
    private int id;
    private String title,category,name,address,mobile,email,paper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;        
    }  
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;        
    }  
    
    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    /**
     * 
     * @param name enter <b>users</b> name here
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;        
    }  
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;        
    }  
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;        
    }  
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaper() {
        return paper;        
    }  
    
    public void setPaper(String paper) {
        this.paper = paper;
    }

}