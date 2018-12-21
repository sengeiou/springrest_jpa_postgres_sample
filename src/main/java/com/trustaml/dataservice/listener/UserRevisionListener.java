

/**
 * This class sets the userId attribute in the Audit table
 */
package com.trustaml.dataservice.listener;



import org.hibernate.envers.RevisionListener;



public class UserRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        AuditEnversInfo auditEnversInfo = (AuditEnversInfo) revisionEntity;
        auditEnversInfo.setUserId(Utilities.getRandomUsers());
    }

}
