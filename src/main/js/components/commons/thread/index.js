import React from 'react';
import { NavLink } from 'react-router-dom';


const Thread = ({title, onlyTitle}) => {

    return onlyTitle ?
        <NavLink to="#" className="list-group-item list-group-item-action flex-column align-items-start">
            <div className="d-flex w-100 justify-content-between">
                <h5 className="mb-1">{title}</h5>
                <small>
                    <img src="http://www.hipertrofia.org/forum/uploads/set_resources_10/84c1e40ea0e759e3f1505eb1788ddf3c_default_club.png"
                         alt="..."
                         className="img-thumbnail thumb"/>
                </small>
            </div>
        </NavLink>
        :
        <NavLink to="#" className="list-group-item list-group-item-action flex-column align-items-start">
            <div className="d-flex w-100 justify-content-between">
                <h5 className="mb-1">{title}</h5>
                <small>
                    <img src="http://www.hipertrofia.org/forum/uploads/set_resources_10/84c1e40ea0e759e3f1505eb1788ddf3c_default_club.png"
                         alt="..."
                         className="img-thumbnail thumb"/>
                </small>
            </div>
            <p className="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius
                blandit.</p>
            <small>Criado por felipernx  3 days ago</small>
        </NavLink>;
};

export default Thread;