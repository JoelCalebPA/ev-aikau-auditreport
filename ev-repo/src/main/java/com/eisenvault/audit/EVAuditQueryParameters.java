package com.eisenvault.audit;

import java.util.Date;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;

/**
 *  Class to represent the parameters for a Audit log query
 */
public final class EVAuditQueryParameters {
	private int maxEntries = -1;
	private String user;
	private NodeRef nodeRef;
	private Date dateFrom;
	private Date dateTo;
	private String event;
	private QName property;
	
	/**
	 * Default Constructor
	 */
	public EVAuditQueryParameters(){
		
	}
	
	/**
	 * 
	 * @return The maximum number of audit trail entries to retrieve
	 */
	public int getMaxEntries() {
		return maxEntries;
	}

	/**
	 * Restricts the retrieved audit trail to the last
	 * <code>maxEntries</code> entries.
	 * 
	 * @param maxEntries Maximum number of entries
	 */
	public void setMaxEntries(int maxEntries) {
		this.maxEntries = maxEntries;
	}

	/**
	 * 
	 * @return The username to filter by
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Restricts the retrieved audit trail to entries made by
	 * the provided user.
	 * 
	 * @param user The username to fitler by
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 
	 * @return The node to get entries for
	 */
	public NodeRef getNodeRef() {
		return nodeRef;
	}
	
	/**
     * Restricts the retrieved audit trail to only those entries
     * created by the give node.
     * 
     * @param nodeRef The node to get entries for
     */
	public void setNodeRef(NodeRef nodeRef) {
		this.nodeRef = nodeRef;
	}

	/**
     * 
     * @return The date to retrieve entries from
     */
	public Date getDateFrom() {
		return dateFrom;
	}
	
    /**
     * Restricts the retrieved audit trail to only those entries
     * that occurred after the given date.
     * 
     * @param dateFrom Date to retrieve entries after
     */	
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
     * 
     * @return The date to retrive entries to
     */
	public Date getDateTo() {
		return dateTo;
	}

	/**
     * Restricts the retrieved audit trail to only those entries
     * that occurred before the given date.
     * 
     * @param dateTo Date to retrieve entries before
     */
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	/**
     * 
     * @return The event to retrive entries for
     */
	public String getEvent() {
		return event;
	}

	/**
     * Restricts the retrieved audit trail to only those entries
     * that match the given event string.
     * 
     * @param event Event to retrieve entries for
     */
	public void setEvent(String event) {
		this.event = event;
	}
	
	/**
     * 
     * @return The property to retrieve entries for
     */
	public QName getProperty() {
		return property;
	}

	/**
     * Restricts the audit trail to only those entries that involve
     * the given property.
     * 
     * @param property The property to retrieve entries for
     */
	public void setProperty(QName property) {
		this.property = property;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		
		builder.append(" (nodeRef='").append(nodeRef).append("', user='")
        .append(user).append("', dateFrom='").append(dateFrom)
        .append("', dateTo='").append(dateTo).append("', maxEntries='")
        .append(maxEntries).append("', event='").append(event)
        .append("', property='").append(property).append("')");
		
		return builder.toString();
	}
}
