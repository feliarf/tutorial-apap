import React from 'react';

//export greeting
export class Greeting extends React.Component {
    render() {
        return <h1>Hi there, {this.props.name}!</h1>;
    }
}

export class Greeting2 extends React.Component {
    render() {
        if (this.props.signedIn == false) {
            return <h1>GO AWAY</h1>;
        } else {
            return <h1>Hi there, {this.props.name}!</h1>;
        }
    }
}