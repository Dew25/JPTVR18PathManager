/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.User;
import entity.UserRoles;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Melnikov
 */
@Stateless
public class UserRolesFacade extends AbstractFacade<UserRoles> {

    @PersistenceContext(unitName = "JPTVR18PathManagerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserRolesFacade() {
        super(UserRoles.class);
    }

    public boolean checkRole(User user, String roleName) {
        try {
            UserRoles ur = (UserRoles) em.createQuery(
               "SELECT ur FROM UserRoles ur WHERE ur.role.name = :roleName AND ur.user = :user")
                    .setParameter("roleName", roleName)
                    .setParameter("user", user)
                    .getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTopRoleName(User user) {
        List<UserRoles> listUserRoles = em.createQuery(
                "SELECT ur FROM UserRoles ur WHERE ur.user = :user")
                .setParameter("user", user)
                .getResultList();
        for (UserRoles userRole : listUserRoles) {
            if("ADMIN".equals(userRole.getRole().getName())){
                return "ADMIN";
            }else if("USER".equals(userRole.getRole().getName())){
                return "USER";
            }
        }
        return null;
    }
    
}
