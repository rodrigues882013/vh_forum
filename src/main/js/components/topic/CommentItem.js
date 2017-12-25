
import React from 'react';
import PropTypes from 'prop-types';

const CommentItem = ({comment}) => {
    return (
        <div className="card-body">
            <div className="card-text">
                <div className="row comment-entry">
                    <div className="col-sm-1 col-md-1">
                        <img src="#" alt="..." className="img-thumbnail rounded-circle thumb"/>
                        <br/>
                        {comment.user.username}
                    </div>
                    <div className="col-sm-10 col-md-10 media-body font-body-comment">
                        {comment.text}
                    </div>
                </div>
            </div>
        </div>
    );
};

CommentItem.propTypes = {
    comment: PropTypes.object.isRequired
};

export default CommentItem;