import React, {Component} from 'react';
import {connect} from 'react-redux';
import {PropTypes} from 'prop-types';
import {withRouter} from 'react-router-dom';
import {bindActionCreators} from 'redux';
import * as topicActions from '../../actions/topicActions';
import _ from 'lodash';

class TopicPage extends Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            topic: this.props.topic,
        };
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentWillMount(){
        this.props.actions.loadTopic();

    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentWillReceiveProps(nextProps){
        if (!_.isEmpty(nextProps.topic)) {
            this.setState({topic: nextProps.topic});
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    onChange(event){

    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    render() {
        return (
            <main className="col-sm-12 ml-sm-auto col-md-12 pt-3" role="main">

                <section className="component row text-left placeholders">
                    <div className="col-sm-6 col-md-6 col-xs-12">

                    </div>
                </section>
            </main>

        );
    }
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function mapStateToProps(state, ownProps) {

    let topic = {
        title: '',
        test: '',
        username: {},
        comments: []
    };

    if (state.topic.length && ownProps.match.params.id !== 'new'){
        topic = Object.assign({}, _.find(state.topics, x => x.id === parseInt(ownProps.match.params.id)));
    }

    return {
        topic: topic
    };
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function mapDispatchToProps(dispatch) {
    return {actions: bindActionCreators(topicActions, dispatch)};
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(TopicPage));