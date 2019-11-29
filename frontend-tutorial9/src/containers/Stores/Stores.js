import React, { Component } from 'react';
import Store from "../../components/Store/Store"
import classes from "./Stores.module.css";
import axios from "../../axios-store.js";
import Modal from "../../components/UI/Modal/Modal";
import Button from "../../components/UI/Button/Button";

class Stores extends Component {
    constructor(props){
        super(props);
        this.state = {
            stores: [],
            allstores: [],
            isCreate: false,
            isEdit:false,
            // [
            //     {id: 1, followers: 2, keterangan: "This is store A", nama: "Store A"},
            //     {id: 2, followers: 3, keterangan: "This is store B", nama: "Store B"},
            //     {id: 3, followers: 4, keterangan: "This is store C", nama: "Store C"}
            // ],
            isLoading: true,
            nama: "",
            keterangan:"",
            followers: ""
        }
        this.handleChangeSearchBar = this.handleChangeSearchBar.bind(this);
    }

    changeHandler = event => {
        const { name, value } = event.target;
        this.setState({[name] : value});
    };

    addStoreHandler = () =>{
        this.setState({ isCreate: true });
    };

    canceledHandler = () => {
        this.setState({isCreate: false, isEdit: false});
    };

    componentDidMount(){
        this.loadStores();
    }

    handleChangeSearchBar(e){
        let currentList = [];
        let newList = [];

        if(e.target.valueOf !== ""){
            currentList = this.state.allstores;
            newList = currentList.filter(store => {
                const storeNama = store.nama.toLowerCase();
                const searchparam = e.target.value.toLowerCase();
                return storeNama.startsWith(searchparam);
            });
        }else {
            newList = this.state.allstores;
        }
        this.setState({
            stores: newList
        });
    }

    loadStores = async () => {
        const fetchedStores = [];
        const response = await axios.get("/stores");
        for (let key in response.data){
            fetchedStores.push({
                ...response.data[key]
            });
        }
        this.setState({
            stores: fetchedStores,
            allstores: fetchedStores,
        });
    };

    shouldComponentUpdate(nextProps, nextState){
        console.log("shouldComponentUpdate");
        return true;
    }

    submitAddStoreHandler = event => {
        event.preventDefault();
        this.setState({isLoading:true});
        this.addStore();
        this.canceledHandler();
    }

    submitEditStoreHandler = event => {
        event.preventDefault();
        this.setState({isLoading: true});
        this.editStore();
        this.canceledHandler();
    };

    async deleteStoreHandler(storeId){
        await axios.delete(`/store/${storeId}`);
        await this.loadStores();
    }

    async editStore(){
        const storeToEdit = {
            id: this.state.id,
            nama: this.state.nama,
            followers: this.state.followers,
            keterangan: this.state.keterangan
        };

        await axios.put("/store/" + this.state.id, storeToEdit);
        await this.loadStores();
    }


    async addStore(){
        const storeToAdd = {
            nama: this.state.nama,
            followers: this.state.followers,
            keterangan: this.state.keterangan
        };

        await axios.post("/store", storeToAdd);
        await this.loadStores();

        this.setState({nama:"", followers:"", keterangan:""});
    }

    editStoreHandler(store){
        this.setState({
            isEdit: true,
            id: store.id,
            nama: store.nama,
            keterangan: store.keterangan,
            followers: store.followers
        });
    }

    loadingHandler = () => {
        const currentIsLoading = this.state.isLoading;
        this.setState({isLoading: !(currentIsLoading)});
        console.log(this.state.isLoading);
    }

    render() {
        //console.log("render()")
        return (
            <React.Fragment>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    modalClosed={this.canceledHandler}
                >
                    {this.renderForm()}
                </Modal>

                <div className={classes.Title}>All Stores </div>
                <div className={classes.ButtonLayout}>
                    <button
                        className={classes.AddStoreButton}
                        onClick={this.addStoreHandler}
                        >
                        + Add New Store
                    </button>
                </div>

                <div className={classes.ButtonLayout}>
                    <input type="text" className="input"
                           onChange={this.handleChangeSearchBar}
                           placeholder="Cari..."/>
                </div>
                <div className={classes.Stores}>
                    {this.state.stores &&
                    this.state.stores.map(store =>
                    <Store
                        key={store.id}
                        nama={store.nama}
                        followers={store.followers}
                        keterangan={store.keterangan}
                        edit={() => this.editStoreHandler(store)}
                        delete={() => this.deleteStoreHandler(store.id)}
                    />
                    )}
                </div>
            </React.Fragment>
        );
    }

    renderForm(){
        const {isEdit} = this.state;
        return(
            <form>
                <input
                    className={classes.Input}
                    name="nama"
                    type="text"
                    placeholder="Name"
                    value = {this.state.nama}
                    onChange={this.changeHandler}
                />
                <input
                    className={classes.input}
                    name="followers"
                    type="number"
                    placeholder="Followers"
                    value = {this.state.followers}
                    onChange={this.changeHandler}
                />
                <textarea
                    className={classes.TextArea}
                    name="keterangan"
                    type="text"
                    value = {this.state.keterangan}
                    placeholder="Description"
                    onChange={this.changeHandler}
                />
                <Button btnType="Danger" onClick={this.canceledHandler}>
                    CANCEL
                </Button>
                <Button btnType="Success" onClick={
                    isEdit? this.submitEditStoreHandler : this.submitAddStoreHandler}>
                    SUBMIT
                </Button>
            </form>
        );
    }
}
export default Stores;
