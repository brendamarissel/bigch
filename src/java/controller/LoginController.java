package controller;
 
import dao.UsuarioDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import org.primefaces.context.RequestContext;
 
@ManagedBean(name = "loginController")
@SessionScoped
 
public class LoginController implements Serializable {
 
    private static final long serialVersionUID = 1L;
     @Column(name="user")
    private String uname;
      @Column(name="password")
    private String password;
       @Column(name="id")
 private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 
    public String loginProject() {
        boolean result = UsuarioDao.login(uname, password);
 
        
       
            
           if(uname.equals("user") && password.equals("user")){
               return "/login2?faces-redirect=true";
           }
           
           else if (uname.equals("admin") && password.equals("admin")) {     
          return "/login1?faces-redirect=true";
         
         
       } 
        
       
       
        
        else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!",
                    "Please Try Again!"));
            return "index";
        }
      
        
        
    }
 
}