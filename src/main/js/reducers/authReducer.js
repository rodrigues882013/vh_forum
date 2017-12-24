import types from '../actions/actionsTypes';
import initialState from './initialState';

export default function authReducer(state = initialState.auth, action){

    let newState = state;

    switch(action.type) {

        case types.LOGIN.SUCCESS:
            newState = !!localStorage.jwt;
            break;

        case types.LOGOFF.SUCCESS:
            newState = !!localStorage.jwt;
            break;
    }

    return newState;
}