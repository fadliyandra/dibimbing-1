package dibimbing.team2.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "transaksi")
@Where(clause = "deleted_date is null")
public class Transaksi extends AbstractDate implements Serializable {
    //GenerationType.AUTO : nextvall all tabel sequense
    // GenerationType.IDENTITY : nextvall per tabel sequense
    @Id
    @Column(name = "id_transaksi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transaksi;

    @ManyToOne
    @JoinColumn(name = "id_barang")
    Barang barang;

    @ManyToOne
    @JoinColumn(name = "id_pembeli")
    Pembeli pembeli;

    private Double harga;

    private Integer qty;

}

