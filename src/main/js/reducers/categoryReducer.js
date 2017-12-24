
import types from '../actions/actionsTypes';
import initialState from './initialState';

export default function categoryReducer(state = initialState.categories, action){

    let newState = state;

    switch(action.type) {

        case types.LOAD.CATEGORIES.SUCCESS:
            newState = action.categories;
            break;

    }

    return newState;
}
