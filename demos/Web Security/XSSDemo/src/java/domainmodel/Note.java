/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author awarsyle
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findByNoteID", query = "SELECT n FROM Note n WHERE n.noteID = :noteID")
    , @NamedQuery(name = "Note.findByDateCreated", query = "SELECT n FROM Note n WHERE n.dateCreated = :dateCreated")
    , @NamedQuery(name = "Note.findByTitle", query = "SELECT n FROM Note n WHERE n.title = :title")
    , @NamedQuery(name = "Note.findByContents", query = "SELECT n FROM Note n WHERE n.contents = :contents")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NoteID")
    private Integer noteID;
    @Basic(optional = false)
    @Column(name = "DateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Contents")
    private String contents;
    @JoinColumn(name = "Owner", referencedColumnName = "Username")
    @ManyToOne(optional = false)
    private User owner;

    public Note() {
    }

    public Note(Integer noteID) {
        this.noteID = noteID;
    }

    public Note(Integer noteID, Date dateCreated, String title, String contents) {
        this.noteID = noteID;
        this.dateCreated = dateCreated;
        this.title = title;
        this.contents = contents;
    }

    public Integer getNoteID() {
        return noteID;
    }

    public void setNoteID(Integer noteID) {
        this.noteID = noteID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noteID != null ? noteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.noteID == null && other.noteID != null) || (this.noteID != null && !this.noteID.equals(other.noteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Note[ noteID=" + noteID + " ]";
    }
    
}
