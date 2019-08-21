package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela AVO
 * @generated
 */
@Entity
@Table(name = "\"AVO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Avo")
public class Avo implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "nome_avo", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nome_avo;

  /**
   * Construtor
   * @generated
   */
  public Avo(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Avo setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome_avo
   * return nome_avo
   * @generated
   */
  
  public java.lang.String getNome_avo(){
    return this.nome_avo;
  }

  /**
   * Define nome_avo
   * @param nome_avo nome_avo
   * @generated
   */
  public Avo setNome_avo(java.lang.String nome_avo){
    this.nome_avo = nome_avo;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Avo object = (Avo)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
