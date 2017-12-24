import React, { Component } from 'react';
import {withRouter} from 'react-router-dom';
import Thread from '../commons/thread';



class Home extends Component {


    constructor(props, context) {
        super(props, context);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentDidMount(){
        this.props.history.push('/home');
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    render() {
        return (
            <main className="col-sm-12 ml-sm-auto col-md-12 pt-3" role="main">
              <h1> Home </h1>

                {/*<section className="row placeholders">*/}
              <div className="row">
                <div className="col-sm-8 col-md-8 col-xs-12">
                  <div className="card">
                    <div className="card-header">
                      Last Update
                    </div>
                    <ul className="list-group list-group-flush">
                      <Thread title="Quantos anos para comprar minha casa?"/>
                      <Thread title="Ajuda para teste"/>
                      <Thread title="Dúvida em estrutura de dados"/>
                    </ul>
                  </div>
                </div>

                <div className="col-sm-4 col-md-4 col-xs-12">
                  <div className="card">
                    <div className="card-header">
                      Popular now
                    </div>
                    <ul className="list-group list-group-flush">
                      <Thread title="Quantos anos para comprar?" onlyTitle={true}/>
                      <Thread title="Ajuda para teste"  onlyTitle={true}/>
                      <Thread title="Dúvida em estrutura de dados" onlyTitle={true}/>
                    </ul>
                  </div>
                </div>
              </div>

              <div className="row m-t">
                <div className="col-sm-8 col-md-8 col-xs-12">
                  <div className="card">
                    <div className="card-header">
                      Foruns
                    </div>
                    <ul className="list-group list-group-flush">
                      <Thread title="Forum 1"/>
                      <Thread title="Forum 2"/>
                      <Thread title="Forum 3"/>
                    </ul>
                  </div>
                </div>
              </div>

                {/*</section>*/}


            </main>

        );
    }
}

export default withRouter(Home);