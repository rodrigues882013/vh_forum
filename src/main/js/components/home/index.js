import React, { Component } from 'react';
import {withRouter} from 'react-router-dom';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import {PropTypes} from 'prop-types';
import * as topicActions from '../../actions/topicActions';
import _ from 'lodash';
import TopicsList from "./TopicsList";
import CategoryList from "./CategoryList";




class Home extends Component {


    constructor(props, context) {
        super(props, context);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentDidMount(){
        this.props.actions.loadTopics();
        this.props.actions.loadCategories();
        this.props.history.push('/home');
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    render() {
        const topics = this.props.topics;
        const categories = this.props.categories;

        return (
            <main className="col-sm-12 ml-sm-auto col-md-12 pt-3" role="main">
                <h1> Home </h1>

                <div className="row">
                    <div className="offset-2 col-sm-8 col-md-8 col-xs-12">
                        <TopicsList topics={topics} titleGroup={"Last update"}/>
                    </div>
                </div>

                <div className="row m-t">
                    <div className="offset-2 col-sm-8 col-md-8 col-xs-12">
                        <CategoryList categories={categories}/>
                    </div>
                </div>
            </main>

        );
    }
}

Home.propTypes = {
    topics: PropTypes.array.isRequired,
    categories: PropTypes.array.isRequired
};

function mapStateToProps(state, ownProps) {
    if (!_.isEmpty(state.topics)){
        return {
            categories: state.categories,
            topics: state.topics,
        };
    } else {

        return {
            categories: [],
            topics: []
        };
    }
}

function mapDispatchToProps(dispatch) {
    return {actions: bindActionCreators(topicActions, dispatch)};
}


export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Home));