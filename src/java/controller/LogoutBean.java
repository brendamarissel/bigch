
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author orlando
 */
@ManagedBean
@RequestScoped
public class LogoutBean {

    /**
     * Creates a new instance of LogoutBean
     */
    public LogoutBean() {
    }

    private static final Logger log = Logger.getLogger(LogoutBean.class.getName());

    public String logout() throws IOException {

        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.invalidateSession();

        } catch (Exception e) {
            log.log(Level.SEVERE, "Hay problemas al cerrar la session!", e);
            return "/login/LoginError?faces-redirect=true";
        }

        return "/login/Login?faces-redirect=true";

    }
}
