package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela PAI
 * @generated
 */
@Entity
@Table(name = "\"PAI\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Pai")
public class Pai implements Serializable {

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
  @Column(name = "nome_pai", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nome_pai;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_avo", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Avo avo;

  /**
   * Construtor
   * @generated
   */
  public Pai(){
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
  public Pai setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome_pai
   * return nome_pai
   * @generated
   */
  
  public java.lang.String getNome_pai(){
    return this.nome_pai;
  }

  /**
   * Define nome_pai
   * @param nome_pai nome_pai
   * @generated
   */
  public Pai setNome_pai(java.lang.String nome_pai){
    this.nome_pai = nome_pai;
    return this;
  }

  /**
   * Obtém avo
   * return avo
   * @generated
   */
  
  public Avo getAvo(){
    return this.avo;
  }

  /**
   * Define avo
   * @param avo avo
   * @generated
   */
  public Pai setAvo(Avo avo){
    this.avo = avo;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Pai object = (Pai)obj;
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
