package com.eisenvault.audit;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.namespace.QName;
import org.alfresco.util.ISO8601DateFormat;
import org.alfresco.util.Pair;

/**
 * Class to represent a EisenVault Audit Entry
 * @author sujay
 *
 */
public final class EVAuditEntry {

	private final Date timestamp;
    private final String userName;
    private final String fullName;
    private final String userRole;
    private final NodeRef nodeRef;
    private final String nodeName;
    private final String nodeType;
    private final String event;
    private final String identifier;
    private final String path;
    private final Map<QName, Serializable> beforeProperties;
    private final Map<QName, Serializable> afterProperties;
    private Map<QName, Pair<Serializable, Serializable>> changedProperties;
    
	public EVAuditEntry(Date timestamp, String userName, String fullName,
			String userRole, NodeRef nodeRef, String nodeName, String nodeType,
			String event, String identifier, String path,
			Map<QName, Serializable> beforeProperties,
			Map<QName, Serializable> afterProperties) {
		super();
		this.timestamp = timestamp;
		this.userName = userName;
		this.fullName = fullName;
		this.userRole = userRole;
		this.nodeRef = nodeRef;
		this.nodeName = nodeName;
		this.nodeType = nodeType;
		this.event = event;
		this.identifier = identifier;
		this.path = path;
		this.beforeProperties = beforeProperties;
		this.afterProperties = afterProperties;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	
	public String getTimestampString(){
		return ISO8601DateFormat.format(this.timestamp);
	}
	
	public String getUserName() {
		return userName;
	}

	public String getFullName() {
		return fullName;
	}

	public String getUserRole() {
		return userRole;
	}

	public NodeRef getNodeRef() {
		return nodeRef;
	}

	public String getNodeName() {
		return nodeName;
	}

	public String getNodeType() {
		return nodeType;
	}

	public String getEvent() {
		return event;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getPath() {
		return path;
	}

	public Map<QName, Serializable> getBeforeProperties() {
		return beforeProperties;
	}

	public Map<QName, Serializable> getAfterProperties() {
		return afterProperties;
	}

	public Map<QName, Pair<Serializable, Serializable>> getChangedProperties() {
		if(changedProperties == null){
			initChangedProperties();
		}
		return changedProperties;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append("(")
          .append("timestamp=").append(timestamp)
          .append(", userName=").append(userName)
          .append(", userRole=").append(userRole)
          .append(", fullName=").append(fullName)
          .append(", nodeRef=").append(nodeRef)
          .append(", nodeName=").append(nodeName)
          .append(", event=").append(event)
          .append(", identifier=").append(identifier)
          .append(", path=").append(path)
          .append(", beforeProperties=").append(beforeProperties)
          .append(", afterProperties=").append(afterProperties)
          .append(", changedProperties=").append(changedProperties)
          .append(")");
        return sb.toString();
	}
	
	private void initChangedProperties(){
		if(beforeProperties != null && afterProperties != null){
			changedProperties = new HashMap<QName, Pair<Serializable, Serializable>>(beforeProperties.size() + afterProperties.size());
			
			for(QName valuePropName : beforeProperties.keySet()){
				Pair<Serializable, Serializable> values = new Pair<Serializable, Serializable>(beforeProperties.get(valuePropName), afterProperties.get(valuePropName));
				changedProperties.put(valuePropName, values);
			}
			
			for(QName valuePropName : afterProperties.keySet()){
				if(!beforeProperties.containsKey(valuePropName)){
					Pair<Serializable, Serializable> values = new Pair<Serializable, Serializable>(null, afterProperties.get(valuePropName));
					changedProperties.put(valuePropName, values);
				}
			}
		}
	}
    
}
