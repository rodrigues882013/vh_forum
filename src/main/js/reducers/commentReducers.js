
import types from '../actions/actionsTypes';
import initialState from './initialState';

export default function commentReducer(state = initialState.comments, action){

    let newState = state;

    switch(action.type) {

        case types.LOAD.COMMENTS.SUCCESS:
            newState = action.comments;
            break;

        case types.CREATE.COMMENT.SUCCESS:
            newState = action.comments;
            break;

        case types.UPDATE.COMMENTS.SUCCESS:
            newState = action.comments;
            break;

        case types.CREATE.COMMENTS.FAILED:
            newState = state;
            break;

    }

    return newState;
}
