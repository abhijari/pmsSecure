/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author root
 */



@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/pms",
        callerQuery = "select password from user where username = ?",
        groupsQuery = "select g.name from user u,usersgroup ug,groups g where ug.groupId = g.Id and ug.userId = u.Id and u.username = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)




@Named
@ApplicationScoped
public class ProjectConfig {
     public ProjectConfig() {
        System.out.println("Project Config Initialized");
    }
}
