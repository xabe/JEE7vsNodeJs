package com.xabe.tutorial.model.rest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.xabe.tutorial.model.Model;

@Entity
@Table(name="t_rest")
@NamedQueries({
  @NamedQuery(name = "Rest.findAll", query = "SELECT m FROM Rest m")})
public class Rest extends Model {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(length=500)
    private String name;

    private Integer number;
    
    public Rest() {
		
	}
    
    public Rest(String name,int number) {
		this.name = name;
		this.number = number;
	}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Rest other = (Rest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        return result;
    }
}
