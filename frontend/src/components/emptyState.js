import React from "react";
import Item from "./Item";

export default function EmptyList({title, items, onItemClick, type}) {
    return (<div className="text-center">
        <h3>Belum ada item yang terpilih</h3>
        <p>Klik salah satu item di daftar produk</p>
        </div> ) ;
}
