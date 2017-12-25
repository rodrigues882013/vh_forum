import React, {Component} from 'react';
import {connect} from 'react-redux';
import {PropTypes} from 'prop-types';
import {withRouter} from 'react-router-dom';
import {bindActionCreators} from 'redux';
import * as topicActions from '../../actions/topicActions';
import * as commentActions from '../../actions/commentActions';
import Header from '../commons/header';
import _ from 'lodash';
import CommentItem from "./CommentItem";
import TextEditor from '../commons/text-editor';
import {EditorState} from 'draft-js';


class TopicPage extends Component {

    constructor(props, context) {
        super(props, context);

        this.state = {
            topic: this.props.topic,
            comments: this.props.comments,
            editorState: this.props.editorState
        };

        this.onChange = (editorState) => this.setState({editorState});
        this._onComment = this._onComment.bind(this);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentWillMount(){
        this.props.commentActions.loadComments(this.state.topic.id);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    componentWillReceiveProps(nextProps){

        if (!_.isEmpty(nextProps.topic)) {
            this.setState({topic: nextProps.topic});
        }

        if (!_.isEmpty(nextProps.comments)) {
            this.setState({comments: nextProps.comments});
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    _onComment(event){
        console.log(this.state)
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    render() {
        const el = this.props.comments.map(c => <CommentItem key={c.id} comment={c}/>);

        return (
            <main className="col-sm-12 ml-sm-auto col-md-12 pt-3" role="main">

                <div className="row">
                    <div className="offset-1 col-sm-10 col-md-10 col-xs-12">
                        <Header
                            icon={<i className="fa fa-globe fa-4x"/>}
                            title="Van Hack Test Forum"
                            text="Some quick example text to build on the card title and make up the bulk of the card's content."/>
                    </div>
                </div>

                <div className="row m-t">
                    <div className="offset-1 col-sm-10 col-md-10 col-xs-12">
                        <div className="card">
                            {el}
                        </div>

                        <div className="card m-t">
                            <TextEditor editorState={this.props.editorState}/>
                        </div>
                        <button onClick={this._onComment}> Post </button>

                    </div>
                </div>

            </main>

        );
    }
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function mapStateToProps(state, ownProps) {

    let topic = Object.assign({}, _.find(state.topics, x => x.id === parseInt(ownProps.match.params.id)));
    let comments = [{text: '', id: '', user: {}}];

    if (!_.isEmpty(state.comments)){
        comments = state.comments;
    }

    return {
        comments: comments,
        topic: topic,
        editorState: EditorState.createEmpty()
    };

}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

function mapDispatchToProps(dispatch) {
    return {
        topicActions: bindActionCreators(topicActions, dispatch),
        commentActions: bindActionCreators(commentActions, dispatch)
    };
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(TopicPage));