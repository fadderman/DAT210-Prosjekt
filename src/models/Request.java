package models;

import javax.persistence.*;


@Entity
@Table(name = "REQUEST")
public class Request {
	
	@Id @GeneratedValue
	@Column(name = "request_id")
	private int requestID;
	
	@Column(name = "traineeRequest")
	private boolean traineeRequest;
	
	@ManyToOne
	@JoinColumn(name = "requestTarget_fk")
	private User requestTarget;
	
	@ManyToOne
	@JoinColumn(name = "connection_fk")
	private Connection connection;
	
	
	public Request(){
		
	}
	
	
	public Request(User requestTarget, Connection connection, boolean isTraineeRequest){
		this.setRequestTarget(requestTarget);
		this.connection = connection;
		setTraineeRequest(isTraineeRequest);

	}
	

	public int getRequestID(){
		return requestID;
	}

	public Connection getConnection() {
		return connection;
	}


	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	public boolean isTraineeRequest() {
		return traineeRequest;
	}


	public void setTraineeRequest(boolean traineeRequest) {
		this.traineeRequest = traineeRequest;
	}


	public User getRequestTarget() {
		return requestTarget;
	}


	public void setRequestTarget(User requestTarget) {
		this.requestTarget = requestTarget;
	}

	

}
