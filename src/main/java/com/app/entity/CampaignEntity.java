package com.app.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class CampaignEntity {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String title;
	    private String description;
	    private String startDate;
	    private String endDate;
	    private Double goalAmount;
	    private Double currentAmount;

	    @ManyToOne
	    @JoinColumn(name = "ngo_id")
	    private NgoEntity ngo;

		public CampaignEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CampaignEntity(Long id, String title, String description, String startDate, String endDate,
				Double goalAmount, Double currentAmount, NgoEntity ngo) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.goalAmount = goalAmount;
			this.currentAmount = currentAmount;
			this.ngo = ngo;
		}

		public CampaignEntity(String title, String description, String startDate, String endDate, Double goalAmount,
				Double currentAmount, NgoEntity ngo) {
			super();
			this.title = title;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.goalAmount = goalAmount;
			this.currentAmount = currentAmount;
			this.ngo = ngo;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public Double getGoalAmount() {
			return goalAmount;
		}

		public void setGoalAmount(Double goalAmount) {
			this.goalAmount = goalAmount;
		}

		public Double getCurrentAmount() {
			return currentAmount;
		}

		public void setCurrentAmount(Double currentAmount) {
			this.currentAmount = currentAmount;
		}

		public NgoEntity getNgo() {
			return ngo;
		}

		public void setNgo(NgoEntity ngo) {
			this.ngo = ngo;
		}
	    
    
}

