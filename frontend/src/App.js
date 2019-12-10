import React from "react";
import List from "./components/List";
import dummyItems from "./items.json";
import "./dark.css"
import EmptyList from "./components/emptyState";
export default class App extends React.Component {
// for class based component, you need to provide render
// function
    constructor(props){
        super(props);
        this.state = {
            favItems: [],
            myFavourite: false,
            showDark : false
        };
    }

    showFavourite = () => {
        this.setState(stateFavourite => ({
            myFavourite: !stateFavourite.myFavourite
        }))
    }

    showDarkMode = () => {
        this.setState(stateDark => ({
            showDark: !stateDark.showDark
        }))
    }

    handleItemClickFav = item =>{
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if(targetInd < 0) newItems.push(newItem);
        else newItems.splice(targetInd, 1);
        this.setState({favItems: newItems});
    };

    handleItemClickProduct = item =>{
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        if(targetInd < 0) newItems.push(newItem);
        this.setState({favItems: newItems});
    };

  render() {
      const { favItems, myFavourite, showDark } = this.state;
    return (
        <div className= {`${showDark? "container-fluid dark" : "container-fluid"}`}>
          <h1 className="text-center">
            Welcome!
            <small>Class-based</small>
              <h6><input type="checkbox" onClick={this.showFavourite}/>Show Favorit</h6>
              <h6><input type="checkbox" onClick={this.showDarkMode}/>Dark Mode</h6>
          </h1>
          <div className="container pt-3" >
            <div className="row">
              <div className="col-sm">
                <List
                    title="Our Menu"
                    items={dummyItems}
                    onItemClick={this.handleItemClickProduct}
                    type="hidden"
                />
              </div>
                <div className={`col-sm ${myFavourite? "d-block" : "d-none"}`}>
                    <div className={`${favItems.length == 0 ? "d-none" : "d-block"}`}>
                    <List
                        title="My Favorite"
                        items={favItems}
                        onItemClick={this.handleItemClickFav}
                        type="checkbox"
                    />
                    </div>
                    <div className={`${favItems.length == 0 ? "d-block" : "d-none"}`}>
                        <EmptyList></EmptyList>
                    </div>
                </div>
            </div>
          </div>
        </div>
    );
  }


}
