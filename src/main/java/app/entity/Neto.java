package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela NETO
 * @generated
 */
@Entity
@Table(name = "\"NETO\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Neto")
public class Neto implements Serializable {

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
  @Column(name = "nome_neto", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String nome_neto;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_pai", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Pai pai;

  /**
   * Construtor
   * @generated
   */
  public Neto(){
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
  public Neto setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém nome_neto
   * return nome_neto
   * @generated
   */
  
  public java.lang.String getNome_neto(){
    return this.nome_neto;
  }

  /**
   * Define nome_neto
   * @param nome_neto nome_neto
   * @generated
   */
  public Neto setNome_neto(java.lang.String nome_neto){
    this.nome_neto = nome_neto;
    return this;
  }

  /**
   * Obtém pai
   * return pai
   * @generated
   */
  
  public Pai getPai(){
    return this.pai;
  }

  /**
   * Define pai
   * @param pai pai
   * @generated
   */
  public Neto setPai(Pai pai){
    this.pai = pai;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Neto object = (Neto)obj;
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
