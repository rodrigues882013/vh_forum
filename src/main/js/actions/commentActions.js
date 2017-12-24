import commentService from '../services/commentService';
import types from './actionsTypes';


/*
 * Action creators
 */

export const loadCommentsSuccess = (comments) => ({type: types.LOAD.COMMENTS.SUCCESS, comments});

export const loadCommentSuccess = (comment) => ({type: types.LOAD.COMMENT.SUCCESS, comment});

export const updateCommentSuccess = (comment)=> ({type: types.UPDATE.COMMENT.SUCCESS, comment});

export const createCommentSuccess = (comment) => ({type: types.CREATE.comment.SUCCESS, comment});

// export const deleteCommentSuccess = (topic) => ({type: types.DELETE.TOPIC.SUCCESS, topic});

/*
* Actions
* */

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function loadComment(id) {

    return function(dispatch){
        return commentService
            .get(id)
            .then( response => dispatch(loadCommentSuccess(response.data)))
            .catch( error => console.error(error));
    };

}
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function loadComments(topicId) {

    return function(dispatch){
        return commentService
            .list(topicId)
            .then( response =>{
                dispatch(loadCommentsSuccess(response.data));

            })
            .catch(error => console.error(error));
    };

}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

// export function deletetopic(id, history) {
//
//     return function(dispatch){
//         return commentService
//             .remove(id)
//             .then( response =>{
//                 dispatch(deletetopicSuccess(response.data));
//                 history.push(`/topics`);
//             })
//             .catch(error => console.error(error));
//     };
//
// }

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

export function updateComment(topicId, commentId, comment, history) {

    return function(dispatch){
        return commentService
            .update(topicId, commentId, comment)
            .then( response =>{
                dispatch(updateCommentSuccess(response.data));
                history.push(`/topics/${topicId}`);
            })
            .catch(error => console.error(error));
    };

}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
export function createComment(topicId, comment, history) {

    return function(dispatch){
        return commentService
            .create(topicId, comment)
            .then( response => {
                dispatch(createCommentSuccess(response.data));
                history.push(`/topics/${topicId}`);

            })
            .catch(error => console.error(error));
    };

}
