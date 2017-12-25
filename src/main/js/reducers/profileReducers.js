
import types from '../actions/actionsTypes';
import initialState from './initialState';

export default function profileReducers(state = initialState.profile, action){

  let newState = state;

  switch(action.type) {
    case types.LOAD.PROFILE.SUCCESS:
      newState = action.profile;
      break;

    case types.CREATE.PROFILE.SUCCESS:
      newState = action.profile;
      break;

    case types.UPDATE.PROFILE.SUCCESS:
      newState = action.profile;
      break;

    case types.CREATE.PROFILE.FAILED:
      newState = state;
      break;

    default:
      return state;
  }

  return newState;
}