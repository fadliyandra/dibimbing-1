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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barang_id")
    Barang barang;

    @ManyToOne
    @JoinColumn(name = "pembeli_id")
    Pembeli pembeli;

    private Double harga;

    private Integer qty;

}

